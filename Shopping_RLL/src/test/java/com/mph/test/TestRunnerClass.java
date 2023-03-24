package com.mph.test;
/**
 * 
 * @author Prasanna_Palanivel
 *
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerClass {

	public static void main(String[] args) {
		Result result =	JUnitCore.runClasses(AllMyTestSuite.class);
		for(Failure fa : result.getFailures()) {
			System.out.println("Failure Result : " + fa.toString());
			
		}
		System.out.println("Success result " +  result.wasSuccessful());
	}

}