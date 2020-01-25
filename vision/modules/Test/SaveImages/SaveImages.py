import libjevois as jevois
import cv2
import numpy as np
class SaveImages:
    # ###################################################################################################
    ## Constructor
    def __init__(self):
        self.frame = 0
        
    # ###################################################################################################
    ## Process function with no USB output
    def processNoUSB(self, inframe):
        img = inframe.getCvBGR()
        cv2.imwrite("/jevois/data/saveimages{}.png".format(self.frame), img)
        self.frame += 1