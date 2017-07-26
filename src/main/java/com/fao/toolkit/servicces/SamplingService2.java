package com.fao.toolkit.servicces;

import org.apache.synapse.core.SynapseEnvironment;
import org.apache.synapse.message.processor.MessageProcessor;

public class SamplingService2 {
	
	public SamplingService2(MessageProcessor messageProcessor,
            SynapseEnvironment synapseEnvironment, String concurrencyPropName,
            String sequencePropName, boolean isDeactivatedAtStartup) {
		
		System.out.println("SamplingService2() START");
		
		System.out.println("SamplingService2() END");
	}

	
}
