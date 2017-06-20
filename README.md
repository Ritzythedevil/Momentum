# Momentum
This Repository hosts the compiled Binaries and executables & Runtimes of Momentum App. The momentum desktop app will download the required files from this repo.


### Folder Structure
- App : Momentum app compiled code
- Runtime : Runtimes
- Executable : Final executables

Following steps will create digest files and commit the code to production repo from where the momentum desktop app downloads the updated code by comparing digest file.
1. Copy following code from momentumapp
    - Compiled class files from out/production/momentumapp/Momentum (APIs, Controllers, Models, Utils)
    - Libraries
    - Resources(All complete folder content. For Data folder only PlaceHolder)
    - MotivationalContent(Only Default)
2. Open hostMomentumRepo project, copy files from Step#5 to App
3. `cd Tools`
4. `javac CreateManifest.java`
5. `java CreateManifest`
6. `git add App/`
7. `git commit -m "message for new release"`
8. `git push origin master`

Caution : Make sure the code commited to github has line separator type set to Linux format(**LF**)