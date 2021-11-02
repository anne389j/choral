/*
 * Copyright (C) 2019 by Saverio Giallorenzo <saverio.giallorenzo@gmail.com>
 * Copyright (C) 2019 by Fabrizio Montesi <famontesi@gmail.com>
 * Copyright (C) 2019 by Marco Peressotti <marco.peressotti@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Library General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this program; if not, write to the
 * Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package choral.types.kinds;

import choral.exceptions.ChoralException;

public class KindApplicationException extends ChoralException {

	private final Kind subject;
	private final Kind object;

	public KindApplicationException( Kind subject, Kind object ) {
		super( "" );
		this.subject = subject;
		this.object = object;
	}

	public Kind getSubject() {
		return subject;
	}

	public Kind getObject() {
		return object;
	}

	public String message() {
		return "ill-formed kind application " + subject + object + ".";
	}

	@java.lang.Override
	public String toString() {
		return "KindApplicationException{" +
				"subject=" + subject +
				", object=" + object +
				'}';
	}
}
