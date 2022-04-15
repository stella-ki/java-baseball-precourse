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
* Util
    - generateRandomNumberString(int, int)
        - 1번째 input 값으로 들어온 int가 최대인 숫자를 2번째 input 값으로 들어온 숫자의 개수 만큼 생성하여 array 반환한다.
    - convertArraytoMap(arrary)
        - input 값으로 들어온 array를 map(array value, index) 형태로 바꿔 반환한다.
        
* GameValue
    - 게임의 값을 map의 형태로 보유하고 있다.
    - isValidValue(String)
        - input으로 들어온 String값이 3자리 수의 숫자 인지 확인한다.
        - 만약 아니라면 IllegalArgumentException을 반환한다.
    
* BaseballGame 
    - 컴퓨터 Player 객체 보유
    - GameResult 객체 보유
    - BaseballGame()
        - 컴퓨터 Player 객체를 생성 한다.
    - start() 
        - 게임의 시작을 뜻한다.  
        - 컴퓨터 Player 객체의 GameValue 객체 생성 및 값을 생성한다.
    - play(map) 
        - input으로 들어온 유저 값과 computer 값을 비교하여 결과를 반환 한다.
    - restart(boolean)
        - input으로 들어온 boolean 값을 이용하여 게임 재시작 여부를 결정 한다.
        
* GameResult
    - int 형태의 strikeCount, ballCount를 변수 보유
    - setStringCount(int)
        - strikeCount값을 설정한다.
    - setBallCount(int)
        - ballCount값을 설정한다.
    - getStrikeCount()
        - strikeCount를 반환한다.
    - getBallCount()
        - ballCount를 반환한다.
    - toString()
        - strike와 ball count를 이용하여 메시지를 출력할 수 있도록 String을 반환한다.
    - isFinished()
        - 3 스트라이크 인 경우 true를 반환한다.
        
* Player
    - GameValue 객제 보유
    - generateComputer()
        - player가 computer인 경우 3자리 서로 다른 수를 생성하여 GameValue를 초기화 한다.
    - inputValue(String)
        - player가 User인 경우 3자리 수를 입력 받아 GameValue를 초기화 한다.
    

    