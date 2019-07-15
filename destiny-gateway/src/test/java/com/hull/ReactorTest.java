package com.hull;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @link{https://www.jianshu.com/p/611f3667c4d2}
 *
 * @author
 * @create 2019-07-02 19:31
 **/

public class ReactorTest {


    @Test
    public void fluxTest(){

        Flux.create((t) -> {
            t.next("create");
            t.next("create1");
            t.complete();
        }).subscribe(System.out::println);

        System.out.println("======================================================");

        Flux.generate(t -> {
            t.next("generate");   //注意generate中next只能调用1次
            t.complete();
        }).subscribe(System.out::println);

        System.out.println("======================================================");

        //单个元素
        Flux.just("just").subscribe(System.out::println);
        //多个元素
        Flux.just("just", "just1", "just2").subscribe(System.out::println);

        System.out.println("======================================================");

        Flux.from(Flux.just("just", "just1", "just2"))
                .subscribe(System.out::println);
        //Mono->Mono
        Flux.from(Mono.just("just")).subscribe(System.out::println);

        System.out.println("======================================================");

        Flux.fromArray(new String[] { "arr", "arr", "arr", "arr" })
                .subscribe(System.out::println);

        System.out.println("======================================================");

        Set<String> v = new HashSet<>();
        v.add("1");
        v.add("2");
        v.add("3");
        Flux.fromIterable(() -> v.iterator()).subscribe(System.out::println);

        System.out.println("======================================================");

        Flux.defer(() -> Flux.just("just", "just1", "just2"))
                .subscribe(System.out::println);

        System.out.println("======================================================");

        Flux.empty().subscribe(System.out::println);

        System.out.println("======================================================");

        Flux.never().subscribe(System.out::println);

        System.out.println("======================================================");
        Flux.range(0, 10).subscribe(System.out::println);

        System.out.println("======================================================");

        Flux.error(new RuntimeException()).subscribe(System.out::println);

    }


    /**
     * interval:创建一个Flux，它以0开始发射长值并递增
     * 全局计时器上指定的时间间隔。如果需求没有及时产生，一个OnError将用来发出信号。IllegalStateException详细说明无法发出的信息。在正常情况下，Flux将永远不会完成。
     * @throws InterruptedException
     */
    @Test
    public void intervalTest() throws InterruptedException {
        Flux.interval(Duration.of(500, ChronoUnit.MILLIS))
                .subscribe(System.out::println);
        //防止程序过早退出，放一个CountDownLatch拦住
        CountDownLatch latch = new CountDownLatch(1);
        latch.await();
    }

}
