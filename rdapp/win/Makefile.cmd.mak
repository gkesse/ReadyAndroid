all:
#================================================
# android_studio
android_start:
	@studio64
#================================================
# gradlew
gradlew_install: 
	@cd $(GPROJECT_SRC) && gradlew installDebug
#================================================
# nox
nox_install: 
	@nox "-apk:$(GPROJECT_APK)"
#================================================
# git
git_push:
	@cd $(GPROJECT_PATH) && git pull && git add --all && git commit -m "Initial Commit" && git push -u origin master
git_push_o:
	@cd $(GPROJECT_PATH) && git add --all && git commit -m "Initial Commit" && git push -u origin master
git_pull:
	@cd $(GPROJECT_PATH) && git pull
git_clone:
	@cd $(GPROJECT_ROOT) && git clone $(GGIT_URL) $(GGIT_NAME) 
#================================================
