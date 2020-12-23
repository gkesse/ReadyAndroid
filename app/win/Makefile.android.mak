all:

android_studio:
	studio64
apk_install:
	adb install $(GPROJECT_APK)
nox_start: 
	Nox
nox_stop: 
	nox_adb kill-server
nox_connect: 
	nox_adb connect $(GNOX_ADDR):$(GNOX_PORT)
nox_install: 
	Nox "-apk:$(GPROJECT_APK)"
avd_start: 
	emulator -avd $(GAVD_NAME)
avd_list: 
	emulator -list-avds
grad_install: 
	cd $(GPROJECT_SRC) && gradlew installDebug
grad_tasks: 
	cd $(GPROJECT_SRC) && gradlew tasks
