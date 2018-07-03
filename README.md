# Android-Platform-Development-Plugin

## Motivation

For regular Android developers there are dozen of features, which can ease the daily routine: they have
resources autogeneration, handy project structures, build configurations inside an IDE, source code
navigation, convenient work with XML layouts and AndroidManifext's, and even more.
For platform developers there is no such tool: it is normal to work with a project, which is highlighted with RED
almost everywhere, building process is always from the command line, all dependencies have to be resolved manually
and so on, and so forth. This plugin is to resolve this issue and give a nice tool for a platform development.

Work in progress.

## DONE
* `Android.bp` support: highlighting

## TODO
* `Android.bp` support: autocomplete for known variables and C flags;
* `Android.mk` support: same as for `Android.bp`;
* `Android.mk` -> `Android.bp` from context menu using `androidmk` tool;
* Use `bpfmt` formatter;
* Platform project structure and dependency control support;
* New platform application template;
* Integration with the out/ directory;
* Create Java/C++ system service with/without lifecycle;
* Work with SELinux policies (adding/deleting rules);
* Trebble: HIDL support;
* Tool for installing/pushing projects on a device: for libraries, binaries, system apps, native libs etc.

## License

```
Copyright © 2018 Vitalii Dmitriev

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
