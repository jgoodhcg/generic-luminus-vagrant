# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure(2) do |config|
 config.vm.provider "virtualbox" do |v|
	v.memory = 2048
 end
 config.vm.box = "ubuntu/trusty64"
 config.ssh.insert_key = false
 config.vm.synced_folder "", "/home/vagrant/project"
 config.vm.synced_folder "~/.m2", "/home/vagrant/.m2"
 config.vm.network "forwarded_port", guest: 3000, host: 3000
 config.vm.network "forwarded_port", guest: 3449, host: 3449
 config.vm.provision "shell", path: "vagrantscript.sh"
end
