DepableLinkedHashMap
---
�����L�[�̃I�u�W�F�N�g��ێ��\��LinkedHashMap

������value��List�ɂȂ��Ă邾��

```Set<Map.Entry<K,V>> entrySet()```�őO�v�f���擾�o���܂��D

V get(Object key) ���\�b�h�͈�Ԗڂ̗v�f��Ԃ��܂�(�񐄏�)

s.refClass �p�b�P�[�W
---
java.lang.reflect�̃��b�p�[�ۂ��N���X

s.logger �p�b�P�[�W
---
�����̃N���X�Ƀ��M���O������ǉ�����D

���M���O������ǉ�����N���X�̃\�[�X�R�[�h��ύX����K�v���Ȃ��̂������D

���O�́C�W����Map�`���Ŏ���D

javassist���C�u�������K�v�D

�Ƃ���N���X�Ƀ��O���Ƃ鏈����ǉ�������@

1. �V�����N���X�����

2. s.logger.StateLogger���p��(����Ȃ�����)

3. ���M���O�叫�N���X��s.logger.annotation.TargetClass�A�m�e�[�V�����̈����Ɏw��

4. ���M���O�ΏۃN���X�Ɠ������\�b�h���`

5. ��`�������\�b�h�Ƀ��O���Ƃ鏈�����L�q����


��) Bank�N���X��doOpen(String name, String passwd)�Ƀ��O���Ƃ鏈����ǉ�
```
import logger.annotation.TargetClass;
import logger.StateLogger;

//�^�[�Q�b�g�N���X��Bank
@TargetClass("Bank")

//s.logger.StateLogger���p��
public class Bank_Logger extends StateLogger {

	//���M���O�ΏۃN���X�Ɠ������\�b�h���`
	public void doOpen (String name, String passwd) {
		//���O���Ƃ鏈�����L�q
		System.out.println("doOpen����΂ꂽ��I");
	}
}
```
