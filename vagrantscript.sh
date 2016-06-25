#!/bin/bash   
sudo apt-get update
sudo apt-get install -y git g++ automake libtool

sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update
sudo apt-get install -y openjdk-8-jre-headless
sudo /var/lib/dpkg/info/ca-certificates-java.postinst configure

cd /usr/local/lib
sudo git clone https://github.com/sass/sassc.git --branch 3.2.1 --depth 1
sudo git clone https://github.com/sass/libsass.git --branch 3.2.1 --depth 1
cd libsass
sudo autoreconf --force --install
cd ..
export SASS_LIBSASS_PATH=/usr/local/lib/libsass
cd sassc
sudo -E make
ln /usr/local/lib/sassc/bin/sassc /usr/local/bin/sassc

sudo curl https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein -o /usr/local/bin/lein
sudo chmod a+x /usr/local/bin/lein
lein

sudo apt-get install -y postgresql postgresql-contrib

sudo -u postgres psql -c "CREATE DATABASE project_dev WITH ENCODING 'UTF8' TEMPLATE template0"
sudo -u postgres psql -c "CREATE DATABASE project_test ENCODING 'UTF8' TEMPLATE template0"
sudo -u postgres psql -c "CREATE USER dev WITH PASSWORD 'dev';"
sudo -u postgres psql -c "CREATE USER test WITH PASSWORD 'test';"
sudo -u postgres psql -c "ALTER DATABASE project_dev OWNER TO dev;"
sudo -u postgres psql -c "ALTER DATABASE project_test OWNER TO test;"

chmod +x /home/vagrant/project/cider-deps-repl

