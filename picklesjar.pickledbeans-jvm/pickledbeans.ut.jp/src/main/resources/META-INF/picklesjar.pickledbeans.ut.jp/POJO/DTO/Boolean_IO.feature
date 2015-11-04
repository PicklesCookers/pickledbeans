
Feature: DTO向け汎用テスト（Boolean I/O）

Background:
	Given テスト対象クラスのインスタンス生成
		And メソッドをテスト対象に指定

@1arg
Scenario Outline: 引数バリエーションテスト
	When メソッド実行（パラメータ："<arg1>"）
	Then 戻り値：<result>
	
	Examples:
		|arg1	|result	|
		|true	|true	|
		|false	|false	|
