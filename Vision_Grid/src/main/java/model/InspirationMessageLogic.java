package model;

import java.util.List;
import java.util.Random;

public class InspirationMessageLogic {

	public String getRandomMessage() {
        // インスピレーションメッセージのリスト
        List<String> messages = List.of(
            "小さな一歩が、大きな夢に繋がります。",
            "未来は今日の行動で変わる！",
            "あなたの可能性は無限大です。",
            "Vision Gridで新しい未来を描きましょう！",
            "失敗を恐れず、次の一歩を踏み出しましょう。",
            "目標に向かって進む勇気が、あなたを輝かせます。",
            "今日の努力が、明日の成功を創ります。",
            "挑戦を続けることで、未来が広がります。",
            "Vision Gridと共に、理想の自分に近づきましょう。",
            "一歩ずつ確実に、目標に向かって進みましょう。",
            "困難の中にこそ、成長のチャンスが隠れています。",
            "努力は決して裏切りません。",
            "継続は力なり。毎日の積み重ねが未来を変えます。",
            "夢を描くだけでなく、一緒に実現していきましょう。",
            "今日という日は、未来への新しいスタートです。",
            "「Where there is a will, there is a way」どんな困難な道でも、それをやり遂げる意志さえあれば必ず道は開けます。"
        );

        // ランダムでメッセージを選択
        Random random = new Random();
        return messages.get(random.nextInt(messages.size()));
    }
}

