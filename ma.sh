#!/bin/bash
now=$(date +'%d_%m_%Y_%H_%M')
`wget -O- http://irail.be/stations/NMBS/008821006 | python -m json.tool > /home/pi/json/antc/ant_$now.json`
`wget -O- http://irail.be/stations/NMBS/008813003 | python -m json.tool > /home/pi/json/bxlc/bxlc_$now.json`
`wget -O- http://irail.be/stations/NMBS/008814001 | python -m json.tool > /home/pi/json/bxlz/bxlz_$now.json`
`wget -O- http://irail.be/stations/NMBS/008892007 | python -m json.tool > /home/pi/json/gsp/gent_$now.json`
`wget -O- http://irail.be/stations/NMBS/008841004 | python -m json.tool > /home/pi/json/luik/luik_$now.json`
`wget -O- http://irail.be/stations/NMBS/008895760 | python -m json.tool > /home/pi/json/nin/nin_$now.json`

