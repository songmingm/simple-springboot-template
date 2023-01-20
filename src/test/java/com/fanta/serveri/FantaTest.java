package com.fanta.serveri;

import com.fanta.server.FantaApp;
import com.fanta.server.common.IgnoreUrls;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 测试类
 *
 * @author mmsong
 */
@SpringBootTest(classes = FantaApp.class)
public class FantaTest {

    @Autowired
    private IgnoreUrls urlConfig;

    @Test
    void ignore() {
        List<String> urls = urlConfig.getUrls();
        for (String url : urls) {
            System.out.println(url);
        }
        System.out.println(urls.size());
    }
}
