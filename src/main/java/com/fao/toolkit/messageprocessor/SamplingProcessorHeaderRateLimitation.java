/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package com.fao.toolkit.messageprocessor;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.SynapseException;
import org.apache.synapse.core.SynapseEnvironment;
import org.apache.synapse.message.processor.impl.ScheduledMessageProcessor;
import org.apache.synapse.message.processor.impl.sampler.SamplingProcessor;
import org.apache.synapse.message.processor.impl.sampler.SamplingProcessorView;
import org.apache.synapse.message.processor.impl.sampler.SamplingService;
import org.apache.synapse.task.Task;

import com.fao.toolkit.servicces.SamplingService2;

public class SamplingProcessorHeaderRateLimitation extends SamplingProcessor {
	
	private static final Log logger = LogFactory.getLog(ScheduledMessageProcessor.class.getName());
	private SamplingProcessorView view;
	
	private static final String CONCURRENCY = "concurrency";
    private static final String SEQUENCE = "sequence";
	
	@Override
    public void init(SynapseEnvironment se) {
        super.init(se);
        
        logger.info("init() START");
        System.out.println("init() START");
        
        try {
            view = new SamplingProcessorView(this);
        } catch (Exception e) {
            throw new SynapseException(e);
        }

        // register MBean
        org.apache.synapse.commons.jmx.MBeanRegistrar.getInstance().registerMBean(view,
                "Message Sampling Processor view", getName());
        
        logger.info("init() END");
        System.out.println("init() END");
    }
	
	@Override
	public void setParameters(Map<String, Object> parameters) {
		logger.info("setParameters() START");
		System.out.println("setParameters() START");
		// TODO Auto-generated method stub
		super.setParameters(parameters);
		
		logger.info("setParameters() END");
		System.out.println("setParameters() END");
	}
	
	@Override
	protected Task getTask() {
		logger.info("getTask() START");
		System.out.println("getTask() START");
		logger.info("getTask() END");
		System.out.println("getTask() END");
		return (Task) new SamplingService2(this, synapseEnvironment, CONCURRENCY, SEQUENCE, isProcessorStartAsDeactivated());
	}
}
