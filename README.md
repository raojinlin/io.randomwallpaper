
# Random wrapper  
  
Provide a random wallpaper.

## Command line options

```

# main
usage: randomwallpaper
 -h,--help             print help
 -p,--provider <arg>   wallpaper provider. 'local'|'unspash'

# local provider

usage: Local wallpaper provider
 -d,--dir <arg>   wallpaper directory
 -h,--help        print help


# unsplash provider
usage: Unsplash wallpaper provider
 -h,--help             print help
 -q,--quantity <arg>   the wallpaper quantity, one of [full, raw, regular,
                       small, thumb]

```
  
You can use it on the gnome desktop.  
  
```bash  
$ mvn install
$ mvn package
$ ./bin/gnome [gnome|unsplash]
```  
Use with crontable, change a wallpaper every day at eight o'clock

```  
DISPLAY=":0"  
PATH=/usr/bin:/bin  
0 8 * * * /bin/bash /path-to/bin/gnome path-to/io.randomwrapper-1.0-SNAPSHOT-jar-with-dependencies.jar
  
```
  ## System requires
 * Java
 * Linux gnome desktop environment
  
  
## Wallpaper source sites  
1.  [https://unsplash.com](https://unsplash.com/)
