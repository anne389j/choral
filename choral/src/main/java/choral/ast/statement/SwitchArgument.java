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

package choral.ast.statement;

import choral.ast.Name;
import choral.ast.Node;
import choral.ast.Position;
import choral.ast.expression.LiteralExpression;
import choral.ast.visitors.ChoralVisitorInterface;

public abstract class SwitchArgument< T > extends Node {
	final T argument;

	SwitchArgument( T argument ) {
		this.argument = argument;
	}

	SwitchArgument( T argument, final Position position ) {
		super( position );
		this.argument = argument;
	}

	public T argument() {
		return this.argument;
	}

	public static class SwitchArgumentLiteral extends SwitchArgument< LiteralExpression > {
		public SwitchArgumentLiteral( LiteralExpression argument ) {
			super( argument, argument.position() );
		}

		@Override
		public < R > R accept( ChoralVisitorInterface< R > v ) {
			return v.visit( this );
		}

		@Override
		public int hashCode() {
			return argument().hashCode();
		}

		@Override
		public boolean equals( Object obj ) {
			if( obj instanceof SwitchArgumentLiteral ) {
				return this.argument().equals( ( (SwitchArgumentLiteral) obj ).argument() );
			}
			return false;
		}

	}

	public static class SwitchArgumentLabel extends SwitchArgument< Name > {
		public SwitchArgumentLabel( Name argument ) {
			super( argument, argument.position() );
		}

		@Override
		public < R > R accept( ChoralVisitorInterface< R > v ) {
			return v.visit( this );
		}

		@Override
		public int hashCode() {
			return argument().hashCode();
		}

		@Override
		public boolean equals( Object obj ) {
			if( obj instanceof SwitchArgumentLabel ) {
				return this.argument().equals( ( (SwitchArgumentLabel) obj ).argument() );
			}
			return false;
		}
	}

	public static class SwitchArgumentDefault extends SwitchArgument< Void > {

		public SwitchArgumentDefault() {
			this( null );
		}

		public SwitchArgumentDefault( final Position position ) {
			this( null, position );
		}

		private SwitchArgumentDefault( Void argument, final Position position ) {
			super( null, position );
		}

		@Override
		public < R > R accept( ChoralVisitorInterface< R > v ) {
			return v.visit( this );
		}

		@Override
		public boolean equals( Object obj ) {
			return obj instanceof SwitchArgumentDefault;
		}
	}
}


