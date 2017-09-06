package com.jmterhelp;


import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.io.IOException;


/**
 * Created by summe on 2017/9/6.
 */
public class WriteHelper implements JavaSamplerClient{
    private SampleResult results;
    private String fileDir;
    private String text;

    public Arguments getDefaultParameters(){
        Arguments params = new Arguments();
        params.addArgument("saveFile","D:\\tmp\\resp.txt");
        params.addArgument("context","text commit.");

        return params;
    }

    public void setupTest(JavaSamplerContext javaSamplerContext) {

    }

    public SampleResult runTest(JavaSamplerContext context) {
        fileDir = context.getParameter("saveFile");
        text =    context.getParameter("context");

        results = new SampleResult();

        results.sampleStart();
        try {
            FileHelper.randomWrite(fileDir, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        results.sampleEnd();

        return results;
    }

    public void teardownTest(JavaSamplerContext javaSamplerContext) {

    }

   public static void main(String[] args){

   }
}
