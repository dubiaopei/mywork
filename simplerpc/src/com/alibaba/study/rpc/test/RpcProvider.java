package com.alibaba.study.rpc.test;

import com.alibaba.study.rpc.framework.RpcFramework;

public class RpcProvider {

	public static void main(String[] args) throws Exception {  
        HelloService service = new HelloServiceImpl();  
        RpcFramework.export(service, 1234);  
    }  
}
