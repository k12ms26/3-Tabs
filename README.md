# 몰입캠프 1주차 [(시연영상)](https://drive.google.com/file/d/14So6S4x1cBvso9hSGsoUcKgws5eADIev/view)
### 사용한 프로그래밍 언어: Kotlin

### 총 3개의 tabs
- FragmentPagerAdapter를 이용해 3개의 fragments를 MainActivity에 묶음.

### 1st tab: Contacts Tab
- 기기의 연락처 정보를 받아와서 listview에 정렬
- SearchView를 추가하여 연락처 검색 가능하도록 기능 추가. (+ custom background 추가 통해 검색창 꾸밈)
- Implicit Intent를 이용한 공유 기능 추가 (연락처에서 특정 인물 or 번호를 탭할시 이름과 번호 등 정보를 공유 가능)
- 검색시 올라온 키보드는 다른 탭으로 넘어갈 때 자동으로 내려가도록 설정함. 
	(다른 두 개의 fragment를 시작할 때 키보드를 자동으로 내리도록 함/ onStart()에서 hideSoftInputFromWindow 이용)

### 2nd tab: Gallery Tab
- drawable에 사진들을 저장해서 gridview에 정렬
- gridview 중 한 사진을 터치하면 ViewPagerActivity로 넘어감. 이때 어떤 사진을 터치했는지 알기 위해 이미지의 배열 뿐 아니라 현재 터치한 사진의 포지션(인덱스)도 넘겨줌

### 3rd tab: Settings Tab
- custom listview를 이용해 각각의 항목 왼쪽에 아이콘 추가. (언어를 잘못 설정해도 언어 설정 activity를 찾아갈 수 있도록)
  - [X] a. 언어 설정
    - SharedPreferences를 이용해 가장 최근의 설정 앱 종료 후에도 유지하도록 함.
    - text가 있는 activity나 fragment마다 (메인화면, 음악화면, 게임화면 등) SharedPreferences의 언어 설정에 따라 그에 맞는 언어가 display되도록 함.
    - 언어를 바꾸지 않았을 때 뒤로 가기를 누르면 직전에 있던 설정 fragment로 돌아가도록 별도 코드 작성.
	- [X] b. 테마 색
    - 언어와 마찬가지로 SharedPreferences를 이용해 가장 최근의 설정이 앱 종료 후에도 유지되도록 함.
		- 각 activity마다 SharedPreferences에 저장된 theme을 적용시킴. 
		- 총 9개의 theme은 theme.xml을 수정하여 추가시킴.
		- 색을 바꾸지 않았을 때 뒤로 가기를 누르면 직전에 있던 설정 fragment로 돌아가도록 별도 코드 작성.
		- 색이 바뀌면 SharedPreferences에 저장된 theme 값을 바꿈. 
	- [X] c. 브라우저
    - 기존 세번째 탭을 관리하는 FreeFragment에서 브라우저라는 부분을 클릭 할 경우 바로 action view를 실행해 브라우저를 띄우고 지정한 url을 로드함
	- [X] d. 음악
    - MediaPlayer class를 이용해 음악 재생. 앱을 종료하지 않는 이상 백그라운드에서도 음악 재생 가능
		- 음량 설정/노래 구간 설정 가능.
		- 특정 노래 재생 중에 다른 노래를 탭하여 들어가면 기존에 재생되던 노래는 일시정지 후 새로운 노래 재생.
		- Textview에서 ellipsize 설정에 Marquee를 추가하여 글자가 움직이도록 만듦.
	- [X] e. 게임
	  - 틱택토: 2인용 게임. Github 참고하여 추가. 
	  - 산수 퀴즈: [참고링크](https://parallelcodes.com/making-complete-android-quiz-game/)
      - 시간 안에, 혹은 시간 제한 없이 간단한 산수 10문제를 푸는 게임. 문제를 로드하면서 기존에 저장되어 있던 문제의 답과 일치할 경우 스코어를 1씩 올리고, 끝났을 때, 혹은 문제를
			틀렸을 때 activity로 스코어를 넘겨주어 resultactivity를 띄움
			- 시간 안에 푸는 퀴즈의 경우, timeunit이라는 java 함수로 milliseconds를 toseconds, tominutes 등의 함수를 이용해 초, 분 단위 등으로 바꾸었고, 이를 onTick 함수에 넣고 오버라이딩해
			남은 시간을 계속 불러옴
			- onBackPressed() 함수를 오버라이딩 해 뒤로가기 버튼을 눌렀을 때 게임에서 운영 되고 있던 타이머 등을 모두 리셋시키도록 함
	- [X] f. 다른 기능
		- 날짜 수정: 안드로이드에서 제공하는 입력 Dialog인 DatePickerDialog 사용, show() 함수로 다이얼로그 창 활성화
		- 시간 수정: 안드로이드에서 제공하는 입력 Dialog인 TimePickerDialog 사용, show() 함수로 다이얼로그 창 활성화
		- 앱 종료: 
      - 다이얼로그를 띄워서 종료 버튼을 누를 경우 ActivityCompat.finishAffinity(this); System.exit(0) 함수 사용
			- finishAffinity의 경우 현재의 모든 부모 액티비티를 종료 시키는 것이고, System.exit() 함수는 현재 액티비티를 종료시킴
			- 즉 모든 액티비티를 종료 시켜 앱을 종료하게 만듦
