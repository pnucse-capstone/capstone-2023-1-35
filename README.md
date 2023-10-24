# 다중운집지역 내 인파 밀집도 계산 및 실시간 위치 추적 웹서비스


## 1.프로젝트소개

### 배경 :

작년 10월경에 발생한 이태원 참사를 통해 인원 과밀 상황에서 발생하는 압사 사고에 대한 대비책이 필요하다는 국민적 시선이 생겨났다. 하지만 실내 인구 과밀 상황에 노출되는 일은 여전히 불가피하며, 실외가 아닌 실내 다중밀집사고에 대한 대비책은 여전히 부족한 실정이다. 이에 따라 본 과제는 다중 운집 지역에서의 실시간 밀집도 계산 및 위치 추적 웹 서비스를 제작하여 인파 사고를 대비하고자 한다.


### 목적 :
-  건물 내 실시간 밀집도 계산 및 위치 추정

 - 다중 운집 지역에서 재난/재해 또는 실종 사고 발생 시, 해당 사용자의 실내 존재 여부 파악
 
  - 다중 운집 지역에서 인파 밀집도에 따른 경보/알람 시스템


### 개발 환경:

<!--#### 💡BackEnd
<img src="https://img.shields.io/badge/springBoot-6DB33F?style=for-the-badge&logo=springBoot&logoColor=white">
<img src="https://img.shields.io/badge/Java-007396?style=flat&logo=OpenJDK&logoColor=white" width="78"/>

#### 💡FrontEnd
<img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">

#### 💡위치 추정
<img src="https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white">
<img src="https://img.shields.io/badge/raspberrypi-A22846?style=for-the-badge&logo=raspberrypi&logoColor=white">
<img src="https://img.shields.io/badge/yolo-00FFFF?style=for-the-badge&logo=yolo&logoColor=white">

#### 💡서버
<img src="https://img.shields.io/badge/amazonec2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white">-->

- Spring Boot 2.7.11
-   JDK 11 
-   AWS EC2 Amazon Linux 2 
-   Python 3.7이상 (무선 기반 위치 추정 기술의 클라이언트)
-   Python 3.11이상 (비전 기반 위치 추정 기술)
-   Raspberry Pi 4 Model B 
-   YOLOv5  
-   Bootstrap
<br>

## 2.팀 소개
#### 팀 네카라쿠배
|이름|이메일|역할|
|:-----:|:-----:|:-----|
|[<img src="https://github.com/zigimi.png" width="150">](https://github.com/zigimi)<br>**[팀장]** 천주희|chju0905@pusan.ac.kr|-   위치 추정 기술, 무선 네트워크 기술 학습 및 개발<br>- YOLOv5를 통한 사람 인식 딥러닝 기술 학습<br>- 다수의 라즈베리파이를 이용한 실시간 위치 추정 기술 개발<br>- 영상 스트리밍 서버 및 웹 서버 기능 구현<br>- 카메라를 이용한 정밀 위치 추정 기술 개발<br>- 서버 간 통신 구현<br>- 서버 배포|
|[<img src="https://github.com/dmstj920.png" width="150">](https://github.com/dmstj920)<br>**[팀원]** 장은서|merry0920@pusan.ac.kr|-   위치 추정 기술, 무선 네트워크 기술 학습 및 개발<br>- YOLOv5를 통한 사람 인식 딥러닝 기술 학습<br>- 웹 UI 화면 구성<br>- 웹 UI 디자인<br>- 반응형 웹 제작<br>- 인원수 및 밀집도 예측 모델 개발|
<br>

## 3.구성도
![구성도](https://github.com/pnucse-capstone/capstone-2023-1-38-1/assets/96936437/4c46b7ad-630e-47a3-a90c-3cabc0f6e9ae)
- 무선 신호 기반 위치 추정

    - 클라이언트와 서버로 나뉘는 본 기술에서 클라이언트는 무선 신호 값을 측정해 서버로 전송하며 서버는 클라이언트에게서 전송 받은 신호 값을 통해 위치를 추정하고 웹 서버로 위치 데이터를 전송한다.
    
- 비전 기반 위치 추정

    - 라즈베리파이를 기반으로 동작하는 파이썬 프로그램이며, 카메라 모듈을 통해 위치 추정을 위한 영상을 제공한다. 객체 인식을 통해 계산된 위치 데이터를 웹 서버에 전송한다.
    
- 객체 인식 결과 영상 스트리밍

    - 파이썬과 Flask 프레임워크를 이용해 구현한 웹 서버이다. 비전 기반 위치 추정에서 저장한 공유 메모리 데이터를 읽어와 화면에 출력한다.
    
- 웹 서비스

    - 백엔드는 스프링부트 프레임워크를 사용하며, 프론트엔드는 부트스트랩 라이브러리를 사용한다. 서버는 클라우드 서버인 Amazon EC2를 기반으로 동작한다.
<br>

## 4. 소개 및 시연 영상
**[주요 기능 웹 페이지]**

|현재 위치 및 밀집도|무선 신호 기반 실시간 밀집도|비전 기반 실시간 위치 추정|
|-----------------|----------------------------|------------------------|
|![현재 위치 및 밀집도](https://github.com/pnucse-capstone/capstone-2023-1-38-1/assets/96936437/7d53c11b-f091-452b-8d90-1ab6ca57a0aa)|![무선 신호 기반 실시간 밀집도](https://github.com/pnucse-capstone/capstone-2023-1-38-1/assets/96936437/ce03144b-c604-4773-9fdd-3740209c961c)|![비전 기반 실시간 위치 추정](https://github.com/pnucse-capstone/capstone-2023-1-38-1/assets/96936437/9f8a2558-d723-48e0-8173-c7cd3f213498)|
<br>

**[시연 영상]**

추가 예정

<!-- [![부산대학교 정보컴퓨터공학부 소개](http://img.youtube.com/vi/zh_gQ_lmLqE/0.jpg)](https://www.youtube.com/watch?v=zh_gQ_lmLqE) --> 


## 5. 사용법