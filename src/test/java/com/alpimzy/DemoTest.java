package com.alpimzy;

import com.github.dreamhead.moco.HttpServer;
import com.github.dreamhead.moco.Request;
import com.github.dreamhead.moco.resource.Content;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import com.github.dreamhead.moco.Runner;
import static com.github.dreamhead.moco.Moco.httpServer;
import static com.github.dreamhead.moco.Runner.runner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MocoRunnerTest {
    private Runner runner;

    @Before
    public void setup() {
        HttpServer server = httpServer(12306);
        server.response("foo");
        runner = runner(server);
        runner.start();
    }

    @After
    public void tearDown() {
        runner.stop();
    }

    @Test
    public void should_response_as_expected() throws IOException {
        Content content = Request.Get("http://localhost:12306").execute().returnContent();
        assertThat(content.asString(), is("foo"));
    }
}
