# 숫자 야구 게임

## 기능 정의 
1. 1부터 9까지 서로 다른 수로 이루어진 세자리 수를 생성
    * 이 세자리 수를 컴퓨터 값이라 칭함
2. User에게 1부터 9까지 3자리 수를 입력 받음
    * 포맷에 맞지 않는 값 입력 시 IllegalArgumentException
    * 이 세자리 수를 유저 값이라 칭함
3. 컴퓨터 값과 유저 값을 비교하여 아래의 분기에 따라 처리
    1) 컴퓨터 값과 유저 값에 같은 수가 전혀 없는 경우
        - nothing
    2) 컴퓨터 값과 유저 값에 같은 수가 다른 자리에 있는 경우
        - (찾은 개수) 볼
    3) 컴퓨터 값과 유저 값에 같은 수가 같은 자리에 있는 경우
        - (찾은 개수) 스트라이크
4. 3번 항목의 결과가 '3 스트라이크'가 될 때까지 반복
5. '3 스트라이크'면 게임 종료
6. User에게 재시작 여부 입력 받음
 
## 구현 목록
* Ball generator
    - ball 생성 로직
    - ball 생성의 format이 다양해 질 수 있으므로 interface로 구현
    - 필요한 상수 config로 추가
    
* Balls
    - ball 검증의 format이 다양해 질 수 있으므로 interface로 구현
    - ball 검증 
        - ball 값을 검증하고, 비정상이라면 IllegalArgumentException을 반환
    - ball 값 저장
    - 필요한 메시지를 message 상수로 추가

* Player
    - Balls 보유
    - computer나 user 역할
    - computer 역할
        - 서로 다른 3자리 생성
    - user 역할
        - Balls 값 받고 저장

* GameResult
    - strike 갯수, ball 갯수 저장
    - 각 갯수에 따라 포맷에 맞는 문구 생성
    - game 성공 여부값 반환 가능
    - 필요한 메시지를 message 상수로 추가
    
* BaseballGame 
    - 게임 결과 저장
    - 게임 시작 
        - computer player의 ball 생성 
    - 게임 초기화 
        - 게임 결과 값을 초기화
    - 게임
        - computer player와 user player의 값을 비교하여 결과 저장

* BaseballGameMachine
    - 화면 출력단           
    - 게임 시작 명령
    - 게임 성공 시 후처리 작업
    - user에게 게임 재시작 여부 확인
    - 필요한 메시지를 message 상수로 추가
 