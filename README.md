# :pushpin: sweethome 프로젝트 

>부동산 중개 홈페이지    

</br>

## 1. 제작 기간 & 참여 인원
- 23.03.09~04.19 진행중
- 4명 팀 프로젝트

</br>

## 2. 사용 기술

####언어 : Java15  / JSP

####프레임워크 : Spring Framework 3.9.6  /  MyBatis  / Bootstrap

####형상관리 : git(Sourcetree)

####DB : Maria Database

####Server : tomcat 9

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

- **URL 정규식 체크** :pushpin: [코드 확인]()
  - Vue.js로 렌더링된 화면단에서, 사용자가 등록을 시도한 URL의 모양새를 정규식으로 확인합니다.
  - URL의 모양새가 아닌 경우, 에러 메세지를 띄웁니다.

- **Axios 비동기 요청** :pushpin: [코드 확인]()
  - URL의 모양새인 경우, 컨텐츠를 등록하는 POST 요청을 비동기로 날립니다.

### 4.3. Controller

![]()

- **요청 처리** :pushpin: [코드 확인]()
  - Controller에서는 요청을 화면단에서 넘어온 요청을 받고, Service 계층에 로직 처리를 위임합니다.

- **결과 응답** :pushpin: [코드 확인]()
  - Service 계층에서 넘어온 로직 처리 결과(메세지)를 화면단에 응답해줍니다.

### 4.4. Service

![]()

- **Http 프로토콜 추가 및 trim()** :pushpin: [코드 확인]()
  - 사용자가 URL 입력 시 Http 프로토콜을 생략하거나 공백을 넣은 경우,  
  올바른 URL이 될 수 있도록 Http 프로토콜을 추가해주고, 공백을 제거해줍니다.

- **URL 접속 확인** :pushpin: [코드 확인]()
  - 화면단에서 모양새만 확인한 URL이 실제 리소스로 연결되는지 HttpUrlConnection으로 테스트합니다.
  - 이 때, 빠른 응답을 위해 Request Method를 GET이 아닌 HEAD를 사용했습니다.
  - (HEAD 메소드는 GET 메소드의 응답 결과의 Body는 가져오지 않고, Header만 확인하기 때문에 GET 메소드에 비해 응답속도가 빠릅니다.)

  ![]()

- **Jsoup 이미지, 제목 파싱** :pushpin: [코드 확인]()
  - URL 접속 확인결과 유효하면 Jsoup을 사용해서 입력된 URL의 이미지와 제목을 파싱합니다.
  - 이미지는 Open Graphic Tag를 우선적으로 파싱하고, 없을 경우 첫 번째 이미지와 제목을 파싱합니다.
  - 컨텐츠에 이미지가 없을 경우, 미리 설정해둔 기본 이미지를 사용하고, 제목이 없을 경우 생략합니다.


### 4.5. Repository

![]()

- **컨텐츠 저장** :pushpin: [코드 확인]()
  - URL 유효성 체크와 이미지, 제목 파싱이 끝난 컨텐츠는 DB에 저장합니다.
  - 저장된 컨텐츠는 다시 Repository - Service - Controller를 거쳐 화면단에 송출됩니다.

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
>프로젝트 개발 회고 글: https://zuminternet.github.io/ZUM-Pilot-integer/
