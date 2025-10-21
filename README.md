# Android-code-snap

[![](https://jitpack.io/v/HanzoDev1375/Android-code-snap.svg)](https://jitpack.io/#HanzoDev1375/Android-code-snap)

![Weekly download statistics](https://jitpack.io/v/HanzoDev1375/Android-code-snap/week.svg)
![Monthly download statistics](https://jitpack.io/v/HanzoDev1375/Android-code-snap/month.svg)

# Screenshot


<div align="center">
  <img src="https://raw.githubusercontent.com/HanzoDev1375/Android-code-snap/main/img/java.png" alt="Screenshot 1" style="width:80%; height: 50%; margin: 3px;">
 
</div>

# Supported languages

- [x] java
- [x] python  
- [x] javascript
- [x] c
- [x] c++
- [x] rust
- [x] php
- [x] html
- [x] css
- [x] kotlin
- [ ] typescript
- [x] csharp
- [x] gradle
- [ ] markdown
- [ ] go
- [ ] swift
- [x] dart
- [ ] ruby
- [ ] scala
- [ ] perl
- [ ] r
- [ ] matlab
- [ ] lua
- [ ] yaml
- [ ] json
- [ ] xml

## Note

- It is currently a test program, but will become a library in the future.

## Features
- [x] Screenshot capability in Png, jpg, webp format
- [ ] Format and screenshot
- [x] Custom theme
- [x] Custom editor


## How to using
- adding to settings.gradle

```groovy

dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}


```

- adding to build.gradle

```groovy

dependencies {
	        implementation 'com.github.HanzoDev1375:Android-code-snap:1.0.1'
}


```

### how to use in project??
adding `xml` in your activity

```xml 

  <ir.ninjacoder.codesnap.LayoutGroup
    android:layout_height="wrap_content"
    android:layout_width="match_parent"
    android:layout_marginEnd="8dp"
    android:layout_marginStart="8dp"
    android:id="@+id/editor"
    android:layout_gravity="center" />
```

### How to Using in java

```java
  private LayoutGroup editor;
  
  editor.setType(#LangType);
  
  editor.takeScreenshot();
  
  editor.getEditor().showLineNumber(#Boolean);
  
  //set full font
  editor.getEditor().setFont(#TypeFace);
  //setEditor font 
  editor.getEditor().setTypeFaceEditor(#TypeFace);
  //setLineNumberFont
  editor.getEditor().setTypeFaceLineNumber(#TypeFace);
  //how to make custom theme? see class #ColorHelper
  editor.getEditor().setColorHelper(#ColorHelper);
  //how to select theme ?
  editor.setTheme(#ThemeManager);
   //see other method in MainActivity
  editor.setText(#String);
```


### Custom Theme

- If you don't have an application class, create one. This is an example.

``` java 

import android.app.Application;
import ir.ninjacoder.codesnap.colorhelper.ThemeLoader;

public class App extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    ThemeLoader.init(this);
    // TODO: Implement this method
  }
}


```

- Then call `ThemeLoader.in(this);` like the code above to create a custom theme.
- Then in Android Manifest adding `android:name=".App"` or name your app class note adding in tag `application`
- Then the method LayoutGroup#setThemeCustom Call and submit the theme path Currently, one custom theme is supported, in the future, multiple themes will be supported if the project is supported.


### How to create a theme custom?

```json
{
  "keyword": "#FFBD93F9",
  "operator": "#FFFF5555",
  "method": "#FF50FA7B",
  "variable": "#FF8BE9FD",
  "symbol": "#FFFFB86C",
  "comment": "#FF6272A4",
  "lastdot": "#FFFFAE77",
  "lastsymi": "#FFFF79C6",
  "uppercase": "#FFE8A2FF",
  "textnormal": "#FFF8F8F2",
  "prebrak": "#FFFF6E6E",
  "predot": "#FF5EF38C",
  "strings": "#FFF1FA8C",
  "linenumbercolor": "#FF9999CC",
  "bracketcolor": "#33FF79C6",
  "htmlkeyword": "#FFFF79C6",
  "htmlattr": "#FF50FA7B",
  "csskeyword": "#FFBD93F9",
  "cssoprator": "#FFFF79C6",
  "cardbackground": "#FF1E1F29",
  "cardstorkecolor": "#FF44475A"
}

```
- using in json


