cnt=3;
for var in `ls image*`; 
do 
mv -f $var $cnt.jpg; 
cnt=`expr $cnt + 1`;
done
