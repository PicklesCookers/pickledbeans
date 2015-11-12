Feature: DTO向け汎用テスト（Boolean I/O）

Background:
	Given テスト対象クラスのインスタンス生成
		And テスト対象の機能を実行対象に指定

Scenario Outline: Getterテスト
	When 実行対象の処理を実行（パラメータ：<arg1>）
	Then 期待値（<result>）と合致するかを確認する
	
	Examples:
		|arg1	|result	|
		|true	|false	|
		|false	|true	|
