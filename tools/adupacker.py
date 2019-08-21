# adupacker
# pack all audio clips data into one
# also generate the index file
# i dont remember what it does but it works
# leave last 7000 bytes, normally 0x00 s

import os

b_p="/".join(k_a[:-1])
bp=b_p+"/aduthah/"
akuruthah=os.listdir(b_p+"/aduthah/")
aduthah=[]
kindex='0,'
inx=0

n=open(b_p+"/adu.bin", "wb")

for akuru in akuruthah:
    for item in os.listdir(bp+akuru):
        aduthah.append(item)
        o=open(bp+akuru+'/'+item, "rb")
        oo=o.read()
        o.close()
        n.write(oo[0x2c:-7000])
        inx+=len(oo[0x2c:-7000])
        kindex+=str(inx)+','

n.close()
k=open(b_p+'/index.txt', "wb")
k.write(kindex[:-1])
k.close()