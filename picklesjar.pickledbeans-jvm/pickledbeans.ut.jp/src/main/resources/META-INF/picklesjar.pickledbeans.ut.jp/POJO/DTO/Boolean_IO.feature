Feature: DTO向け汎用テスト（Boolean I/O）

Background:
	Given テストID："UTD001000000"

Scenario Outline: 引数バリエーションテスト
	Given "clear"により初期化
	When "Set&Get"処理実行( <arg> )
	Then 戻り値：<result>
	
	Examples:
		|arg	|result	|
		|true	|true	|
		|false	|false	|
