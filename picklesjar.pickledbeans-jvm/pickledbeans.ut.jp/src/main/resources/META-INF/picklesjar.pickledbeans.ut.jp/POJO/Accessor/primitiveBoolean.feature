Feature: Accessor向け汎用テスト（boolean I/O）

Background:
	Given テスト対象クラスのインスタンス生成
		And テスト対象の処理を実行対象に指定

@ACCESSOR_GETTER_AND_SETTER_PAIR
Scenario Outline: Setter --> Getter I/O 確認
	When Setter実行（パラメータ：<arg1>）
		And Getter実行（パラメータ：なし）
	Then 期待値（<result>）と合致するかを確認する
	
	Examples:
		|arg1	|result	|
		|true	|true	|
		|false	|false	|

@DETAIL
@ACCESSOR_SETTER
Scenario Outline: Setter処理 詳細確認
	When 実行対象の処理を実行（パラメータ：<arg1>）
		And Accessorデータ保持変数の値を取得、保持（alias："Accessorデータ保持変数の値"）
	Then 期待値（<result>）と合致するかを確認する（alias："Accessorデータ保持変数の値"）
	
	Examples:
		|arg1	|result	|
		|true	|true	|
		|false	|false	|

@DETAIL
@ACCESSOR_GETTER
Scenario Outline: Getter処理 詳細確認
	When Accessorデータ保持変数に値を設定（パラメータ：<arg1>）
		And 実行対象の処理を実行（パラメータ：なし）、処理結果を保持
	Then 期待値（<result>）と合致するかを確認する
	
	Examples:
		|arg1	|result	|
		|true	|true	|
		|false	|false	|
