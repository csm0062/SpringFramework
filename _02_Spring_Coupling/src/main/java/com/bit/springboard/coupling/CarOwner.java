package com.bit.springboard.coupling;

public class CarOwner {
    public static void main(String[] args) {
        // 의존성이 두 개가 생기면서 결합도가 높아진다.
        // 또 다른 클래스변수가 생기면 계속해서 결합도가 높아질 수 밖에 없는 구조
        KiaCar kiaCar = new KiaCar();
        HyundaiCar hyundaiCar = new HyundaiCar();

        kiaCar.engineOn();
        kiaCar.engineOff();
        kiaCar.speedDown();
        kiaCar.speedUp();

        hyundaiCar.engineOn();
        hyundaiCar.engineOff();
        hyundaiCar.speedUp();
        hyundaiCar.speedDown();
    }
}
