DepableLinkedHashMap
---
同名キーのオブジェクトを保持可能なLinkedHashMap

実装はvalueがListになってるだけ

```Set<Map.Entry<K,V>> entrySet()```で前要素が取得出来ます．

V get(Object key) メソッドは一番目の要素を返します(非推奨)

s.refClass パッケージ
---
java.lang.reflectのラッパーぽいクラス

s.logger パッケージ
---
既存のクラスにロギング処理を追加する．

ロギング処理を追加するクラスのソースコードを変更する必要がないのが特徴．

ログは，標準はMap形式で取れる．

javassistライブラリが必要．

とあるクラスにログをとる処理を追加する方法

1. 新しいクラスを作る

2. s.logger.StateLoggerを継承(いらないかも)

3. ロギング大将クラスをs.logger.annotation.TargetClassアノテーションの引数に指定

4. ロギング対象クラスと同じメソッドを定義

5. 定義したメソッドにログをとる処理を記述する


例) BankクラスのdoOpen(String name, String passwd)にログをとる処理を追加
```
import logger.annotation.TargetClass;
import logger.StateLogger;

//ターゲットクラスはBank
@TargetClass("Bank")

//s.logger.StateLoggerを継承
public class Bank_Logger extends StateLogger {

	//ロギング対象クラスと同じメソッドを定義
	public void doOpen (String name, String passwd) {
		//ログをとる処理を記述
		System.out.println("doOpenがよばれたよ！");
	}
}
```
