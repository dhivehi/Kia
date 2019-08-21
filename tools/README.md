### adupacker.py
Script to stitch all individual clips into one \[adu.bin] and index.txt file .
all audio clips must be mono 16bit 22050Hz wav.  

folder structure:  
```
aduthah / <index><akuru> / <akuru><fili>
```

### Main.java
compile it as kia.jar to make a standalone version of kia with a GUI  
change line 79, 148, 162, 193 with the full path to where this file is located before compiling
keep adu.bin and header.bin in same folder when compiling.
