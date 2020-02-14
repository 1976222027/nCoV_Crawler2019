package fun.ticsmyc.main;


import fun.ticsmyc.service.InformationService;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 用于可执行jar包。。。
 * @author Ticsmyc
 * @package fun.ticsmyc.main
 * @date 2020-01-26 21:51
 */
public class Main {
    public static void main(String[] args) {
        //每十分钟执行一次  3600 000一小时
        new Timer("testTimer").schedule(new TimerTask() {
            @Override
            public void run() {
                fffffuck();
            }
        }, 1000,3600000);
    }

    public static void fffffuck(){
        InformationService informationService = new InformationService();
        informationService.getNews();
    }
}
