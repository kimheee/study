@ echo  off
echo ==================
echo [PROCESSING ...] git add --all.
���� [% 1 ] EQU [(
echo [ó�� �� ...] git commit -m " SpringLecture % date % "
) else (
echo [ó�� �� ...] git commit -m % 1
)
echo [ó�� �� ...] git push
echo ==================

echo [PROCESSING ...] git add --all.
�ڽ� �߰� - ���.
���� [% 1 ] EQU [(
���� .
echo [ó�� �� ...] git commit -m " SpringLecture % date % "
���� .
git commit -m " SpringLecture % date % "
) else (
���� .
echo [ó�� �� ...] git commit -m % 1
���� .
git commit -m % 1
)
���� .
echo [ó�� �� ...] git push
���� .
git push