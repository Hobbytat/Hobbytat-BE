package com.example.hobbytat.domain;

public enum HobbyType {
    ARTIST("예술가",true,"https://hobbytat.s3.ap-northeast-2.amazonaws.com/cd83291f-d16b-4713-8ae1-475279085f3e"),
    EXPLORER("탐험가",true, "https://hobbytat.s3.ap-northeast-2.amazonaws.com/KakaoTalk_20240706_050718700_08.png"),
    SPORTSMAN("스포츠맨",true,"https://hobbytat.s3.ap-northeast-2.amazonaws.com/b92716cd-6171-4f1d-92e7-4482020bd38a"),
    HOBBYCRAFTER("지식 탐구가",true,"https://hobbytat.s3.ap-northeast-2.amazonaws.com/d954270a-eb3b-41f6-835c-9786da470832"),
    KNOWLEDGESEEKER("취미 공예가",true,"https://hobbytat.s3.ap-northeast-2.amazonaws.com/102301f5-d391-451e-8d74-3a13af0d22bc"),
    ARTHOBBYCRAFTER("예술적인 취미 공예가",false,"https://hobbytat.s3.ap-northeast-2.amazonaws.com/ae949c97-92b6-46a1-a7b0-75ac957f6c3c"),
    KNOWLEDGESPORTSMAN("지적인 스포츠맨",false,"https://hobbytat.s3.ap-northeast-2.amazonaws.com/1292b364-a653-431e-be4a-8c17d35a8d7f"),
    KNOWLEDGEHOBBYCRAFTER("지적인 취미 공예가",false, "https://hobbytat.s3.ap-northeast-2.amazonaws.com/8c72d1e6-0ee6-49b3-a5a9-4a6c05dda494");


    private String koName;
    private boolean haveBoard;
    private String url;

    public String getUrl() {
        return url;
    }

    HobbyType(String koName,boolean haveBoard,String imgUrl){
        this.koName=koName;
        this.haveBoard=haveBoard;
        this.url = imgUrl;
    }
}
