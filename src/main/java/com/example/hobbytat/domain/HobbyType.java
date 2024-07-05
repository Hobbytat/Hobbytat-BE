package com.example.hobbytat.domain;

public enum HobbyType {
    ARTIST(
            "예술가",true,"https://hobbytat.s3.ap-northeast-2.amazonaws.com/cd83291f-d16b-4713-8ae1-475279085f3e",
                "예술가 유형의 사람들은 창의적이고 표현적인 활동을 즐깁니다. 이들은 그림 그리기, 음악 작곡, 글쓰기 등 예술적인 취미에 몰두하며, 자신만의 독창적인 작품을 만드는 데 열정을 쏟습니다. 세부적인 디테일과 감성적인 표현에 강점을 가지며, 예술을 통해 감정을 표현하고 타인과 소통하는 것을 중요시합니다. 독창성과 상상력이 풍부하여 새로운 아이디어를 시도하고, 예술을 통해 삶의 의미와 아름다움을 찾습니다. 이러한 활동을 통해 자신의 내면을 탐구하고 성취감을 느낍니다."
            ),
    EXPLORER(
            "탐험가",true, "https://hobbytat.s3.ap-northeast-2.amazonaws.com/KakaoTalk_20240706_050718700_08.png",
            "탐험가 유형의 사람들은 모험과 새로운 경험을 즐깁니다. 이들은 하이킹, 캠핑, 여행 등 야외 활동에 열정을 가지며, 자연을 탐험하고 새로운 장소를 발견하는 것을 좋아합니다. 항상 새로운 도전과 자극을 추구하며, 다양한 문화와 사람들을 만나고 배우는 것을 중요시합니다. 역동적이고 활동적인 성격으로, 신체적 활동과 모험을 통해 삶의 활력을 얻습니다. 세상을 탐험하며 자신의 경계를 넓히고, 독특한 경험을 통해 풍부한 삶을 추구합니다."
    ),
    SPORTSMAN(
            "스포츠맨",true,"https://hobbytat.s3.ap-northeast-2.amazonaws.com/b92716cd-6171-4f1d-92e7-4482020bd38a",
            "스포츠맨 유형의 사람들은 신체 활동과 경쟁을 즐깁니다. 이들은 축구, 농구, 테니스 등 다양한 스포츠에 열정을 가지며, 팀워크와 개인 기록을 중시합니다. 규칙적인 운동을 통해 건강을 유지하고, 운동을 통해 스트레스를 해소하며 에너지를 발산합니다. 목표를 설정하고 도전하며, 성취감을 느끼는 것을 좋아합니다. 스포츠를 통해 얻는 성취감과 팀원들과의 협력이 이들에게 큰 만족감을 줍니다."
            ),
    HOBBYCRAFTER(
            "지식 탐구가",true,"https://hobbytat.s3.ap-northeast-2.amazonaws.com/d954270a-eb3b-41f6-835c-9786da470832",
            "취미공예가 유형의 사람들은 손으로 무언가를 만드는 창작 활동을 즐깁니다. 이들은 뜨개질, 목공, 도자기, 비즈 공예 등 다양한 공예 활동에 열정을 가지고, 세부적인 디테일과 정성을 기울여 작품을 만듭니다. 창의력과 실용성을 결합하여 실용적이면서도 아름다운 물건을 만드는 것을 좋아합니다. 공예 활동을 통해 집중력과 성취감을 얻으며, 자신만의 독특한 작품을 완성하는 기쁨을 느낍니다. 이러한 활동은 스트레스를 해소하고, 마음의 평화를 찾는 데 도움을 줍니다."
    ),
    KNOWLEDGESEEKER(
            "취미 공예가",true,"https://hobbytat.s3.ap-northeast-2.amazonaws.com/102301f5-d391-451e-8d74-3a13af0d22bc",
            "지식탐구가 유형의 사람들은 학습과 정보 수집을 즐깁니다. 이들은 독서, 다큐멘터리 시청, 온라인 강의 수강 등 다양한 방법을 통해 새로운 지식을 얻고자 합니다. 호기심이 많고 다양한 주제에 관심이 있어, 깊이 있는 연구와 토론을 통해 이해의 폭을 넓히는 것을 좋아합니다. 문제 해결과 분석적인 사고에 능하며, 지적 도전을 통해 성취감을 느낍니다. 이러한 활동을 통해 지속적으로 성장하고, 자신과 세상에 대한 이해를 깊게 합니다."
    ),
    ARTHOBBYCRAFTER(
            "예술적인 취미 공예가",false,"https://hobbytat.s3.ap-northeast-2.amazonaws.com/ae949c97-92b6-46a1-a7b0-75ac957f6c3c",
            "예술적인 취미 공예가 유형의 사람들은 창의력과 손재주를 결합한 공예 활동을 즐깁니다. 이들은 도예, 비즈 공예, 수공예 등 다양한 예술적 공예에 몰두하며, 작품을 통해 감정을 표현합니다. 디테일과 미적 감각에 강점을 가지며, 자신만의 독특한 스타일을 작품에 반영합니다. 창작 과정에서 큰 만족감을 느끼며, 완성된 작품을 통해 성취감을 얻습니다. 이러한 활동은 스트레스를 해소하고, 마음의 평화를 찾는 데 큰 도움이 됩니다."
    ),
    KNOWLEDGESPORTSMAN(
            "지적인 스포츠맨",false,"https://hobbytat.s3.ap-northeast-2.amazonaws.com/1292b364-a653-431e-be4a-8c17d35a8d7f",
            "지적인 스포츠맨 유형의 사람들은 신체 활동과 함께 전략적 사고를 즐깁니다. 이들은 체스, 골프, 테니스와 같은 스포츠를 통해 신체적 능력뿐만 아니라 지적 도전을 경험합니다. 스포츠 활동에서 전략을 세우고 분석하는 과정을 중요시하며, 게임의 규칙과 전술을 깊이 이해하려고 노력합니다. 경쟁을 통해 성취감을 느끼고, 지속적으로 자신의 기술을 향상시키는 것을 목표로 합니다. 이러한 활동은 신체적 건강을 유지하면서도, 두뇌를 자극하여 전체적인 균형을 추구하는 데 도움이 됩니다."
    ),
    KNOWLEDGEHOBBYCRAFTER(
            "지적인 취미 공예가",false, "https://hobbytat.s3.ap-northeast-2.amazonaws.com/8c72d1e6-0ee6-49b3-a5a9-4a6c05dda494",
            "지적인 취미 공예가 유형의 사람들은 창의력과 분석적 사고를 결합한 공예 활동을 즐깁니다. 이들은 목공, 도예, DIY 프로젝트 등 복잡한 공예 작업을 통해 세부적인 계획과 실행 과정을 중요시합니다. 창작 과정에서 문제를 해결하고 새로운 기술을 배우며, 지적 도전을 경험하는 것을 좋아합니다. 결과물의 실용성과 미적 가치를 동시에 추구하며, 작품을 통해 성취감을 느낍니다. 이러한 활동은 집중력과 인내심을 기르고, 마음의 평화를 찾는 데 큰 도움이 됩니다."
            );


    private String koName;
    private boolean haveBoard;
    private String url;
    private String description;

    public String getUrl() {
        return url;
    }

    public String getDescription() { return description; }

    HobbyType(String koName,boolean haveBoard,String imgUrl,String description){
        this.koName=koName;
        this.haveBoard=haveBoard;
        this.url = imgUrl;
        this.description = description;
    }
}
