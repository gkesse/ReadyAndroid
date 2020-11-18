android_studio:
	studio64
apk_install:
	adb install $(GAPK)
nox_start: 
	Nox
nox_stop: 
	nox_adb kill-server
nox_connect: 
	nox_adb connect $(GSERVER_IP):$(GSERVER_PORT)
nox_install: 
	Nox "-apk:$(GAPK)"
avd_start: 
	emulator -avd $(GAVD_NAME)
avd_list: 
	emulator -list-avds
grad_install: 
	cd $(GPROJECT) && gradlew installDebug
grad_tasks: 
	cd $(GPROJECT) && gradlew tasks
