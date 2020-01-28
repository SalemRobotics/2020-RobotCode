# 2020-RobotCode

### Contributing

To contribute to this code base, please

1. Create your own branch off of a branch you wish to work from (typically master).
```bash
$ git init
(master)$ git remote add origin https://github.com/SalemRobotics/2020-RobotCode.git
(master)$ git pull origin master
(master)$ git checkout -b new_branch_name
```
2. Create any changes to the robotcode that you might have
3. Save and commit your changes. Any individual task should be a seperate commit.
```bash
(new_branch_name)$ git add --all
(new_branch_name)$ git commit -m "An informative commit message that briefly summarizes any changes you made"
(new_branch_name)% git push -u origin new_branch_name
```
4. Once you have made all the changes you wish to make, submit a pull request to merge your changes into master.
5. Ask another teammate to review your changes, and thoroughly test for bugs on the robot before merging to master.
6. Once changes have been tested on the robot, and are bug-free, someone (preferably not you) will approve your merge request and delete your branch.
