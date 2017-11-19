package com.scarlatti;

import org.springframework.binding.convert.service.DefaultConversionService;
import org.springframework.binding.expression.Expression;
import org.springframework.binding.expression.ExpressionParser;
import org.springframework.binding.expression.ParserContext;
import org.springframework.binding.expression.ParserException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.ContextResource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.FlowBuilder;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.execution.FlowExecutionContext;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.executor.FlowExecutor;

import org.springframework.webflow.expression.el.WebFlowELExpressionParser;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;
import org.springframework.webflow.mvc.view.FlowViewResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * ~     _____                                    __
 * ~    (, /  |  /)                /)         (__/  )      /)        ,
 * ~      /---| // _ _  _  _ __  _(/ __ ___     / _ _  __ // _ _/_/_
 * ~   ) /    |(/_(//_)/_)(_(/ ((_(_/ ((_)   ) / (_(_(/ ((/_(_((_(__(_
 * ~  (_/                                   (_/
 * ~  Friday, 11/17/2017
 */
@Configuration
public class FlowConfig extends AbstractFlowConfiguration {

    /**
     * Register a flow definition with a flow ID.
     * The flow ID is the URL path that we will hit to activate the flow.
     * The flow location must specify "classpath:".
     * Otherwise, Spring throws an exception "cannot locate ServletContext resource"
     * The / is not necessary when using "classpath:".
     * @return the flow definition registry for this application.
     */
    @Bean
    public FlowDefinitionRegistry flowDefinitionRegistry(FlowBuilderServices flowBuilderServices) {
        return getFlowDefinitionRegistryBuilder(flowBuilderServices)
            .addFlowLocation("classpath:flow.xml", "loginFlow").build();
    }

    @Bean
    public FlowExecutor flowExecutor(FlowDefinitionRegistry flowDefinitionRegistry) {
        return getFlowExecutorBuilder(flowDefinitionRegistry).build();
    }

    @Bean
    public FlowHandlerAdapter flowHandlerAdapter(FlowExecutor flowExecutor) {
        FlowHandlerAdapter flowHandlerAdapter = new FlowHandlerAdapter();
        flowHandlerAdapter.setFlowExecutor(flowExecutor);
        return flowHandlerAdapter;
    }

    /**
     * We need this bean to specify that we want Spring to map
     * incoming request paths to a flow id.
     *
     * @param flowDefinitionRegistry the registry to use
     * @return the mapping specification...
     */
    @Bean
    public FlowHandlerMapping flowHandlerMapping(FlowDefinitionRegistry flowDefinitionRegistry) {
        FlowHandlerMapping flowHandlerMapping = new FlowHandlerMapping();
        flowHandlerMapping.setFlowRegistry(flowDefinitionRegistry);
        flowHandlerMapping.setOrder(0);
        return flowHandlerMapping;
    }

    @Bean
    public FlowBuilderServices flowBuilderServices(MvcViewFactoryCreator mvcViewFactoryCreator) {
        return getFlowBuilderServicesBuilder().setViewFactoryCreator(mvcViewFactoryCreator).build();
    }

//    @Bean
//    public Object sillyBean(FlowBuilderServices flowBuilderServices, MvcViewFactoryCreator mvcViewFactoryCreator) {
//        flowBuilderServices.setViewFactoryCreator(mvcViewFactoryCreator);
//        return null;
//    }

    @Bean
    public MvcViewFactoryCreator mvcViewFactoryCreator(ViewResolver viewResolver) {
        MvcViewFactoryCreator mvcViewFactoryCreator = new MvcViewFactoryCreator();
        List<ViewResolver> viewResolvers = new ArrayList<>();
        viewResolvers.add(viewResolver);
        mvcViewFactoryCreator.setViewResolvers(viewResolvers);

        return mvcViewFactoryCreator;
    }
}
