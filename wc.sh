echo
echo Letters:
wc -m `find src -type f` | grep total
echo
echo Lines:
wc -l `find src -type f` | grep total