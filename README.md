# :pushpin: sweethome 프로젝트 

>부동산 중개 홈페이지    

</br>

## 1. 제작 기간 & 참여 인원
- 23.03.09~04.19 진행중
- 4명 팀 프로젝트

</br>

## 2. 사용 기술

- 언어 : Java15  / JSP

- 프레임워크 : Spring Framework 3.9.6  /  MyBatis  / Bootstrap

- 형상관리 : git(Sourcetree) https://github.com/sweethome0426/sweet

- DB : Maria Database

- Server : tomcat 9

</br>

## 3. ERD 설계
![]()


## 4. 핵심 기능
이 서비스의 핵심 기능은 부동산 계약과 포장이사 계약 기능입니다.  
사용자는 원하는 부동산을 계약할 수 있고,
원하는 날짜에 포장이사 계약을 할 수 있습니다.

<details>
<summary><b>핵심 기능 설명 펼치기</b></summary>
<div markdown="1">

### 4.1. 전체 흐름
![]()

### 4.2. 사용자 요청
![]()

- **** :pushpin: [코드 확인]()
  - 
  - 

### 4.3. Controller

![]()

- **** :pushpin: [코드 확인]()
  - Controller에서는 요청을 화면단에서 넘어온 요청을 받고, Service 계층에 로직 처리를 위임합니다.

- **결과 응답** :pushpin: [코드 확인]()
  - Service 계층에서 넘어온 로직 처리 결과(메세지)를 화면단에 응답해줍니다.

### 4.4. Service

![]()

- **** :pushpin: [코드 확인]()
  - 


### 4.5. Repository

![]()

- **** :pushpin: [코드 확인]()
  - 
  - 

</div>
</details>

</br>

## 5. 핵심 트러블 슈팅
### 5.1. 컨텐츠 필터와 페이징 처리 문제
- 

- 
- 

<details>
<summary><b>기존 코드</b></summary>
<div markdown="1">

</div>
</details>

-   
- 

<details>
<summary><b>개선된 코드</b></summary>
<div markdown="1">


</div>
</details>

</br>

## 6. 그 외 트러블 슈팅
<details>
<summary></summary>
<div markdown="1">


</div>
</details>

    
</br>

## 6. 회고 / 느낀점
>프로젝트 개발 회고 글: 
