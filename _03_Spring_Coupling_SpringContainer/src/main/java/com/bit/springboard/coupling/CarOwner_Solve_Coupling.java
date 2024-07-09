package com.bit.springboard.coupling;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarOwner_Solve_Coupling {
    public static void main(String[] args) {
        // 1. 스프링 컨테이너 구동
        // 스프링 컨테이너 객체 생성.
        // bean 엘리먼트로 등록되어 있는 클래스들의 객체 자동으로 생성
        AbstractApplicationContext factory =
                new GenericXmlApplicationContext("root-context.xml");

        // 2. 의존성 검색(DL: Dependency LookUp): bean 객체로 생성된 객체를 찾는 기능
        //    의존성 주입(DI: Dependency Injection): 의존성 검색으로 찾은 객체를 변수에 담아주는 기능

        // 인터페이스 상속을 통한 다형성 구축을 통해 결합도를 낮추는 방식
        Car car = (Car)factory.getBean("kiaCar");

        car.engineOff();
        car.engineOn();
        car.speedDown();
        car.speedUp();

        car = factory.getBean("hyundaiCar", Car.class);

        car.engineOff();
        car.engineOn();
        car.speedDown();
        car.speedUp();

        // 3. 스프링 컨테이너 구동 종료
        factory.close();
    }
}
