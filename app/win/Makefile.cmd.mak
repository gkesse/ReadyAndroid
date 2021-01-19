all:
#================================================
# android
android_studio:
	studio64
android_install:
	sdkmanager "$(GANDROID_PACKAGE)"
apk_install:
	adb install $(GPROJECT_APK)
#================================================
# nox
nox_start: 
	Nox
nox_stop: 
	nox_adb kill-server
nox_connect: 
	nox_adb connect $(GNOX_ADDR):$(GNOX_PORT)
nox_install: 
	Nox "-apk:$(GPROJECT_APK)"
#================================================
# avd
avd_start: 
	emulator -avd $(GAVD_NAME)
avd_list: 
	emulator -list-avds
#================================================
# gradlew
grad_install: 
	cd $(GPROJECT_SRC) && gradlew installDebug
grad_tasks: 
	cd $(GPROJECT_SRC) && gradlew tasks
#================================================
# adb
adb_shell: 
	adb shell $(argv)
#================================================
# git
git_push:
	@cd $(GPROJECT_PATH) && git pull && git add --all && git commit -m "Initial Commit" && git push -u origin master
git_clone:
	@cd $(GPROJECT_ROOT) && git clone $(GGIT_URL) $(GGIT_NAME) 
#================================================
