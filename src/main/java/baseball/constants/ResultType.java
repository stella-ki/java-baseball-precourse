package baseball.constants;

public enum ResultType {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String value;
    
    ResultType(String value){ 
        this.value = value; 
    } 
    
    public String getValue(){ 
        return value; 
    }

}
