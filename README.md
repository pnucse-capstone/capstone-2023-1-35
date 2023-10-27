# 다중운집지역 내 인파 밀집도 계산 및 실시간 위치 추적 웹서비스
> 본 프로젝트는 부산대학교 제6공학관 2층을 기준으로 개발되었습니다.

## 1.프로젝트 소개

### 배경 :

작년 10월경에 발생한 이태원 참사를 통해 인원 과밀 상황에서 발생하는 압사 사고에 대한 대비책이 필요하다는 국민적 시선이 생겨났습니다. 하지만 실내 인구 과밀 상황에 노출되는 일은 현재도 불가피하며, 실외가 아닌 실내 다중밀집사고에 대한 대비책은 여전히 부족한 실정입니다. 이에 따라 본 프로젝트는 **다중 운집 지역에서의 실시간 밀집도 계산 및 위치 추적 웹 서비스**를 제작하여 인파 사고를 대비하고자 합니다.


### 기능 :
-  **건물 내 실시간 위치 추정 및 밀집도 계산**
	-  건물의 평면도 상에서 격자로 된 구역 중 사용자의 현재 위치를 해당 구역의 밀집도 등급에 따른 색상으로 표시합니다.
	-  무선 신호 기반 밀집도와 비전 기반 실시간 위치를 나타냅니다.

 - **다중 운집 지역에서 재난/재해 또는 실종 사고 발생 시, 해당 사용자의 실내 존재 여부 파악**
 	- 관리자로 로그인 시, 사용자의 이메일 검색을 통해 해당 사용자의 현재 위치 혹은 마지막 위치와 기록 시간을 나타냅니다.
 	- 사용자로 로그인 시, 이웃의 이메일 검색을 통해 해당 사용자의 현재 위치 혹은 마지막 위치와 기록 시간을 나타냅니다.
	- 화재와 같은 사고 또는 실종 사고가 발생했을 때, 이 정보를 통해 구조가 가능합니다.

  - **다중 운집 지역에서 인파 밀집도에 따른 경보/알람 시스템**
	- 사용자의 현재 위치 구역의 밀집도 등급이 "위험" 이상이 되었을 때, 경고 알림창을 보여줍니다.



### 개발 환경:

#### 💡BackEnd
<img src="https://img.shields.io/badge/springBoot-6DB33F?style=for-the-badge&logo=springBoot&logoColor=white"> <img src="https://img.shields.io/badge/Java-007396?style=flat&logo=OpenJDK&logoColor=white" width="78"/>

#### 💡FrontEnd
<img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">

#### 💡위치 추정
<img src="https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white"> <img src="https://img.shields.io/badge/raspberrypi-A22846?style=for-the-badge&logo=raspberrypi&logoColor=white"> <img src="https://img.shields.io/badge/yolo-00FFFF?style=for-the-badge&logo=yolo&logoColor=white">

#### 💡서버
<img src="https://img.shields.io/badge/amazonec2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white">

<!-- - Spring Boot 2.7.11
-   JDK 11 
-   AWS EC2 Amazon Linux 2 
-   Python 3.7이상 (무선 기반 위치 추정 기술의 클라이언트)
-   Python 3.11이상 (비전 기반 위치 추정 기술)
-   Raspberry Pi 4 Model B 
-   YOLOv5  
-   Bootstrap-->
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
- **무선 신호 기반 위치 추정**

    - 클라이언트와 서버로 나뉘는 본 기술에서 클라이언트는 무선 신호 값을 측정해 서버로 전송하며 서버는 클라이언트에게서 전송 받은 신호 값을 통해 위치를 추정하고 웹 서버로 위치 데이터를 전송합니다.
    
- **비전 기반 위치 추정**

    - 라즈베리파이를 기반으로 동작하는 파이썬 프로그램이며, 카메라 모듈을 통해 위치 추정을 위한 영상을 제공합니다. 객체 인식을 통해 계산된 위치 데이터를 웹 서버에 전송합니다.
    
- **객체 인식 결과 영상 스트리밍**

    - 파이썬과 Flask 프레임워크를 이용해 구현한 웹 서버입니다. 비전 기반 위치 추정에서 저장한 공유 메모리 데이터를 읽어와 화면에 출력합니다.
    
- **웹 서비스**

    - 백엔드는 스프링부트 프레임워크를 사용하며, 프론트엔드는 부트스트랩 라이브러리를 사용합니다. 서버는 클라우드 서버인 Amazon EC2를 기반으로 동작합니다.
<br>

## 4. 소개 및 시연 영상
**[주요 기능 웹 페이지]**

|현재 위치 및 밀집도|무선 신호 기반 실시간 밀집도|비전 기반 실시간 위치 추정|
|-----------------|----------------------------|------------------------|
|![현재 위치 및 밀집도](https://github.com/pnucse-capstone/capstone-2023-1-38-1/assets/96936437/7d53c11b-f091-452b-8d90-1ab6ca57a0aa)|![무선 신호 기반 실시간 밀집도](https://github.com/pnucse-capstone/capstone-2023-1-38-1/assets/96936437/ce03144b-c604-4773-9fdd-3740209c961c)|![비전 기반 실시간 위치 추정](https://github.com/pnucse-capstone/capstone-2023-1-38-1/assets/96936437/9f8a2558-d723-48e0-8173-c7cd3f213498)|
<br>

**[시연 영상]**

[![부산대학교 정보컴퓨터공학부 소개](http://img.youtube.com/vi/yn6vRykNeKs/0.jpg)](https://youtu.be/yn6vRykNeKs?feature=shared)


<!-- [![부산대학교 정보컴퓨터공학부 소개](http://img.youtube.com/vi/zh_gQ_lmLqE/0.jpg)](https://www.youtube.com/watch?v=zh_gQ_lmLqE) --> 


## 5. 사용법

**[소프트웨어 요구사항]**

- **localization-fingerprint-master**
	
	- Python 3.7 이상

	- 클라이언트의 경우 리눅스 기반의 OS

- **yolov5-master**

	- Python 3.11 이상
	
	- YOLOv5에서 기본적으로 요구하는 패키지 목록과 버전

			gitpython>=3.1.30
			matplotlib>=3.3
			numpy>=1.22.2
			opencv-python>=4.1.1
			Pillow>=7.1.2
			psutil
			PyYAML>=5.3.1
			requests>=2.23.0
			scipy>=1.4.1
			thop>=0.1.1 
			torch>=1.8.0 
			torchvision>=0.9.0
			tqdm>=4.64.0
			ultralytics>=8.0.147
			pandas>=1.1.4
			seaborn>=0.11.0
			setuptools>=65.5.1

		설치방법: 
		```bash
		cd yolov5-master
		// yolov5-master로 이동

		pip install -r requirements.txt
		// 요구사항 다운로드
		```

- **density_check_web_service**
	
	- Spring Boot 2.7.11 
	
	- JDK 11 

<br>

**[사용법]**

- **웹서비스만 확인할 경우**

	a. density_check_web_service폴더의 density_check_web_service-0.0.1-SNAPSHOT.jar를 실행합니다.

	b. http://localhost:8080 으로 접속합니다.

	(혹은 http://ec2-43-202-149-63.ap-northeast-2.compute.amazonaws.com:8080/ 에 접속하시면 테스트 데이터로 동작하는 모습을 확인할 수 있습니다.)

<br>

- **전체 동작 확인**

	<U>density_check_web_service의 실행이 yolov5-master와 localization-fingerprint-master보다 선행되어야 합니다.</U>

	<U>또한 현재 프로젝트의 모든 IP 주소는 localhost로 변경되어 있습니다. 로컬 환경에서 모든 프로젝트 구동 시에는 IP 주소를 입력/변경하지 않아도 됩니다.</U>

	- density_check_web_service

		1. density_check_web_service\src\main\resources\static\camera-location.html의 539번째 Line의 arr변수에 yolov5-master 프로젝트를 실행하는 환경의 IP주소 + :5000을 카메라 위치와 번호에 맞게 배열에 입력합니다.
	
		2. 프로젝트를 빌드 및 실행합니다.
			
			```bash
			cd density_check_web_service
			./gradlew build
			java -jar ./build/libs/density_check_web_service-0.0.1-SNAPSHOT.jar
			```
		
		3. 실행 후 로그인 -> 관리자 페이지 -> 회원 관리 페이지(/user_management)에 접속하여 현재 소지한 라즈베리파이(3.의 클라이언트) MAC 주소를 찾아 로그인한 아이디를 등록합니다.

	- yolov5-master 

		1. 카메라 모듈이 있는 환경에서 실행합니다.

		2. detect.py의 215번째 Line의 주소를 density_check_web_service를 실행하는 환경의 IP주소 + :8080/cameraLocation으로 수정합니다.
	
		3. detect.py의 217번째 Line의 ip 변수의 값을 카메라 번호에 맞게 수정합니다.
		
		4. detect.py의 204번째 Line의 center 변수와 311번째 Line의 source_coord 변수에 카메라 설치 위치에 맞는 좌표를 입력합니다.
		
		5. detect.py를 실행합니다.

			```bash
			python3 detect.py
			```
		
		6. app.py를 실행합니다.

			```bash
			python3 app.py
			```

	- localization-fingerprint-master

		1. 공통 설정
		
			- common.py 파일을 열어서 서버 ip, 서버 port 번호, 폴더 등등을 설정합니다.

		2. 라디오 맵 생성을 위한 데이터 수집
  	
			- 클라이언트 : rpi 폴더에서 measure-1 폴더 내부의 모든 파일을 삭제하고, measure-realtime-1 폴더 내부의 모든 파일을 삭제합니다.
			
			- 서버 : server 폴더에서 measure-1 폴더 내부의 모든 파일을 삭제하고, measure-outcome-1 폴더 내부의 모든 파일을 삭제합니다.
			
			- 서버: server 폴더에서 2-server-main.py의 144번째 Line의 주소를 density_check_web_service를 실행하는 환경의 IP주소 + :8080/sendLocations로 수정합니다.

			- 클라이언트(RPi) : 1-client-setup.py x y n 을 각 cell-block에서 실행합니다.

				```bash
				cd rpi

				// 예시
				python3 1-client-setup.py 0 0 10
				python3 1-client-setup.py 0 1 10
				python3 1-client-setup.py 1 0 10
				.
				.
				.
				```
			
				(x,y) cell-block의 인덱스 (물리적인 실제 좌표 아님)
				
				n = 동일한 cell-block에서 몇번 반복해서 측정을 할지 (기본값 = 5)
				
				measure-1 이라는 폴더가 생성되어 있어야 하고, 폴더안에는 아무런 파일이 없어야 함
				
				프로그램 구동 후, measure-1 폴더 내에 많은 파일이 생성되어 있음

			- 서버 : 1-receive-setup.py를 실행합니다.

				```bash
				cd server
				python3 1-receive-setup.py
				```

				RPi 클라이언트가 보내주는 radio measurement 파일을 수신하는 코드
				
				USE_INTERNET_CONN=True 이면 실제로 클라이언트로부터 전송받은 데이터로 radio map 만들고 False 이면, 서버 로컬에 저장된 데이터를 이용해서 radio map 만듦
				
				서버쪽에는 measure-outcome-1 이라는 폴더가 만들어져 있어야 함

			- 클라이언트(rpi) : 2-upload-setup.py를 실행합니다.

				```bash
				python3 2-upload-setup.py
				```

				서버쪽 1-receive-setup.py가 먼저 구동하고 있는 상태에서 구동해야 함
				
				클라이언트의 measure-1 폴더 내의 파일을 서버에게 전달 해 주는 코드

		3. 위치 추정

			- 서버 : 2-server-main.py의 146번째 Line의 주소를 density_check_web_service를 실행하는 환경의 IP주소 + :8080/sendLocations로 수정합니다.
			
			- 서버: 2-server-main.py를 실행합니다.

				```bash
				python3 2-server-main.py
				```

				실시간 위치 추적 결과를 (y,x) 형태로 출력함

			- 클라이언트(rpi) : 3-client-main.py 실행합니다.

				```bash
				python3 3-client-main.py
				```
				
				서버 2-server-main.py를 먼저 실행하고, 다음으로 이 코드를 실행
				
				실시간으로 rss 값을 측정하고, 그 결과를 서버 2-server-main.py로 보내줌

			- 클라이언트의 위치를 서버가 실시간으로 추정하여 그 결과를 웹 서버로 전송합니다.

		(만약 6공학관 2층에서 사용한다면 위치추정부터 실행해도 정상적으로 동작합니다.)
