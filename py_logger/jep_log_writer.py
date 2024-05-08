import logging
from pathlib import Path
from datetime import datetime
import os


def logger_(s_str, msg):
    #
    filename = f"{s_str}_{datetime.now().strftime('%Y%m%d%H')}.log"
    #
    try:
        # working_dir_ = os.path.dirname(__file__)
        working_dir_ = Path(__file__)
        # log_folder = os.path.join(working_dir_, "host_logs")
        log_folder = working_dir_.parent / "host_logs"

        if not os.path.isdir(log_folder):
            os.makedirs(log_folder)
        #
        log_dest = os.path.join(log_folder, filename)
        logger = logging.getLogger(__name__)
        logger.setLevel(logging.DEBUG)
        if os.path.isfile(log_dest):
            logging.basicConfig(filemode='a')
        #
        logger_file = logging.FileHandler(log_dest)
        # logger_file.setLevel(logging.DEBUG)
        logger_file.setLevel(logging.INFO)
        #
        formatter = logging.Formatter('%(asctime)s: %(levelname)s - %(message)s')
        logger_file.setFormatter(formatter)
        logger.addHandler(logger_file)
        # logger.debug(msg)
    except Exception as e:
        print("file write fail b/c: \n", e)
    return None