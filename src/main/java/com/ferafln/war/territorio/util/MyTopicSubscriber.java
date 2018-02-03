/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.territorio.util;

/**
 *
 * @author feraf
 */
public class MyTopicSubscriber implements Observer {
	
	private String name;
	private Subject topic;
	
	public MyTopicSubscriber(String nm){
		this.name=nm;
	}
	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if(msg == null){
			System.out.println(name+":: No new message");
		}else
		System.out.println(name+":: Consuming message::"+msg);
	}

	

}
