package com.example.blackjack

enum class Cards(val num: Int,val suit: Int,val image: String) {
    JOKER(0, 5, "ジョーカー"),
    S1(1, 4, "スペードの1"),
    S2(2, 4, "スペードの2"),
    S3(3, 4, "スペードの3"),
    S4(4, 4, "スペードの4"),
    S5(5, 4, "スペードの5"),
    S6(6, 4, "スペードの6"),
    S7(7, 4, "スペードの7"),
    S8(8, 4, "スペードの8"),
    S9(9, 4, "スペードの9"),
    S10(10, 4, "スペードの10"),
    S11(11, 4, "スペードのJ"),
    S12(12, 4, "スペードのQ"),
    S13(13, 4, "スペードのK"),
    H1(1, 3, "ハートの1"),
    H2(2, 3, "ハートの2"),
    H3(3, 3, "ハートの3"),
    H4(4, 3, "ハートの4"),
    H5(5, 3, "ハートの5"),
    H6(6, 3, "ハートの6"),
    H7(7, 3, "ハートの7"),
    H8(8, 3, "ハートの8"),
    H9(9, 3, "ハートの9"),
    H10(10, 3, "ハートの10"),
    H11(11, 3, "ハートのJ"),
    H12(12, 3, "ハートのQ"),
    H13(13, 3, "ハートのK"),
    D1(1, 2, "ダイヤの1"),
    D2(2, 2, "ダイヤの2"),
    D3(3, 2, "ダイヤの3"),
    D4(4, 2, "ダイヤの4"),
    D5(5, 2, "ダイヤの5"),
    D6(6, 2, "ダイヤの6"),
    D7(7, 2, "ダイヤの7"),
    D8(8, 2, "ダイヤの8"),
    D9(9, 2, "ダイヤの9"),
    D10(10, 2, "ダイヤの10"),
    D11(11, 2, "ダイヤのJ"),
    D12(12, 2, "ダイヤのQ"),
    D13(13, 2, "ダイヤのK"),
    C1(1, 1, "クラブの1"),
    C2(2, 1, "クラブの2"),
    C3(3, 1, "クラブの3"),
    C4(4, 1, "クラブの4"),
    C5(5, 1, "クラブの5"),
    C6(6, 1, "クラブの6"),
    C7(7, 1, "クラブの7"),
    C8(8, 1, "クラブの8"),
    C9(9, 1, "クラブの9"),
    C10(10, 1, "クラブの10"),
    C11(11, 1, "クラブのJ"),
    C12(12, 1, "クラブのQ"),
    C13(13, 1, "クラブのK")
}