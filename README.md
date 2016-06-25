# project

generated using Luminus version "2.9.10.50"


## Prerequisites
Install:
[virtualbox][1]
[vagrant][2]

[1]: https://www.virtualbox.org/wiki/Downloads
[2]: https://www.vagrantup.com/docs/installation/ 


## Running

To get started running a development server locally,

- clone the project, then in the directory run `vagrant up`

This will download the **base box** first (may take a moment), then it will run the **provision script** (vagrantscript.sh). The provision script installs java, clojure, lein, postgres, and sets up the postgres dev and testing databases. This is not a fast process during initial set up. Be patient and expect a lot of red ugly output.

- when the vagrant machine is running the background and you have a fresh prompt run `vagrant ssh`

This will give you ssh access to the VM as the _vagrant_ user. 

- `cd project/` to get to the src code foler

- `tmux` to start a tmux session.

This is needed to have two panes each run a process that are both required for development.

- `lein run` to start the web server.

The first time this is run lein will have to download the **standalone clojure jar**, then all the project dependencies, be patient.

- `ctrl-b "` or `ctrl-b %` to create a new pane in tmux

- `ctrl-b down` or `ctrl-b right` to focus on the new pane

- `lein figwheel` to start the second required process

_lein run_ starts the development web server on **port 3000**, _lein figwheel_ starts a cljs listening process that will re-compile cljs files when they are changed and push them to the browser automatically **no refresh necessary!** _lein figwheel_ will also take a few moments to start up the first time. The initial set up is easy but time consuming. It is worth it though. Borth processes will be continually running during all development sessions. Once they stop spitting out tons of output about dependencies you will be good to go. 

- open a browser on your host machine and request `localhost:3000` in the url bar. You will see an error page about figwheel needing to be started for a moment or two and then it will compile and you will see the landing page.

## License

Copyright © 2016 FIXME
