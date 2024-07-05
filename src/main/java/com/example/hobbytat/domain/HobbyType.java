package com.example.hobbytat.domain;

public enum HobbyType {
    ARTIST("예술가",true),
    EXPLORER("탐험가",true),
    SPORTSMAN("스포츠맨",true),
    HOBBYCRAFTER("지식 탐구가",true),
    KNOWLEDGESEEKER("취미 공예가",true),
    ARTHOBBYCRAFTER("예술적인 취미 공예가",false),
    KNOWLEDGESPORTSMAN("지적인 스포츠맨",false),
    KNOWLEDGEHOBBYCRAFTER("지적인 취미 공예가",false);


    private String koName;
    private boolean haveBoard;

    private

    HobbyType(String koName,boolean haveBoard){
        this.koName=koName;
        this.haveBoard=haveBoard;
    }
}
